import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeatherinfoComponent } from './weatherinfo.component';

describe('WeatherinfoComponent', () => {
  let component: WeatherinfoComponent;
  let fixture: ComponentFixture<WeatherinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeatherinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeatherinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
